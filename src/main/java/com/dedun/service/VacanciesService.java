package com.dedun.service;

import com.dedun.dto.request.VacanciesRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.dto.response.VacanciesResponse;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Employer;
import com.dedun.model.Vacancies;
import com.dedun.repository.EmployerRepository;
import com.dedun.repository.VacanciesRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VacanciesService {

    private final EmployerRepository employerRepository;
    private final VacanciesRepository vacanciesRepository;

    public VacanciesService(EmployerRepository employerRepository, VacanciesRepository vacanciesRepository) {
        this.employerRepository = employerRepository;
        this.vacanciesRepository = vacanciesRepository;
    }

    public VacanciesResponse create(VacanciesRequest vacanciesRequest, int id) throws HeadHunterException {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.EMPLOYER_NOT_EXIST));
        Vacancies vacancies = new Vacancies(vacanciesRequest.getCity(), vacanciesRequest.getSalary(),
                vacanciesRequest.getWorkExperience(), vacanciesRequest.getDateOfPlacement(), vacanciesRequest.getStatus(), employer);
        vacanciesRepository.save(vacancies);
        return new VacanciesResponse(vacancies.getId(), vacancies.getCity(), vacancies.getSalary(),
                vacancies.getWorkExperience(), vacancies.getDateOfPlacement(), vacancies.getStatus(),
                new EmployerResponse(employer.getId(), employer.getLogin(), employer.getEmployerName(), employer.getFirstName(),
                        employer.getLastName(), employer.getEmail()));
    }


    public List<VacanciesResponse> getAll() {
        return vacanciesRepository.findAll().stream().map(vacancies -> new VacanciesResponse(vacancies.getId(),
                vacancies.getCity(), vacancies.getSalary(), vacancies.getWorkExperience(), vacancies.getDateOfPlacement(), vacancies.getStatus(),
                new EmployerResponse(vacancies.getEmployer().getId(), vacancies.getEmployer().getLogin(), vacancies.getEmployer().getEmployerName(),
                        vacancies.getEmployer().getFirstName(), vacancies.getEmployer().getLastName(), vacancies.getEmployer().getEmail()))).collect(Collectors.toList());

    }


    public VacanciesResponse getVacancyById(int id) {
        Vacancies vacancies = vacanciesRepository.getById(id);
        return new VacanciesResponse(vacancies.getId(),
                vacancies.getCity(), vacancies.getSalary(), vacancies.getWorkExperience(), vacancies.getDateOfPlacement(), vacancies.getStatus(),
                new EmployerResponse(vacancies.getEmployer().getId(), vacancies.getEmployer().getLogin(), vacancies.getEmployer().getEmployerName(),
                        vacancies.getEmployer().getFirstName(), vacancies.getEmployer().getLastName(), vacancies.getEmployer().getEmail()));
    }


    public VacanciesResponse edit(VacanciesRequest vacanciesRequest, int id) throws HeadHunterException {
        Vacancies vacancies = vacanciesRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.VACANCY_NOT_EXIST));
        vacancies.setCity(vacanciesRequest.getCity());
        vacancies.setSalary(vacanciesRequest.getSalary());
        vacancies.setWorkExperience(vacanciesRequest.getWorkExperience());
        vacancies.setDateOfPlacement(vacanciesRequest.getDateOfPlacement());
        vacancies.setStatus(vacanciesRequest.getStatus());
        vacanciesRepository.save(vacancies);
        return new VacanciesResponse(vacancies.getId(),
                vacancies.getCity(), vacancies.getSalary(), vacancies.getWorkExperience(), vacancies.getDateOfPlacement(), vacancies.getStatus(),
                new EmployerResponse(vacancies.getEmployer().getId(), vacancies.getEmployer().getLogin(), vacancies.getEmployer().getEmployerName(),
                        vacancies.getEmployer().getFirstName(), vacancies.getEmployer().getLastName(), vacancies.getEmployer().getEmail()));
    }


    public void delete(int id) throws HeadHunterException {
        Vacancies vacancies = vacanciesRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.VACANCY_NOT_EXIST));
        vacanciesRepository.delete(vacancies);
    }
}
