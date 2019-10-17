package com.dedun.service;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Employer;
import com.dedun.model.Vacancies;
import com.dedun.repository.EmployerRepository;
import com.dedun.repository.VacanciesRepository;
import com.dedun.validator.EmployerValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployerService {
    private final EmployerRepository employerRepository;
    private final EmployerValidator employerValidator;
    private final VacanciesRepository vacanciesRepository;


    public EmployerService(EmployerRepository employerRepository,
                           EmployerValidator employerValidator, VacanciesRepository vacanciesRepository) {
        this.employerRepository = employerRepository;
        this.employerValidator = employerValidator;
        this.vacanciesRepository = vacanciesRepository;
    }

    public EmployerResponse saveEmployer(EmployerRequest employerRequest) throws HeadHunterException {
        employerValidator.checkEmployerAlreadyExist(employerRequest);
        Employer employer = new Employer(employerRequest.getLogin(), null,
                employerRequest.getEmployerName(), employerRequest.getFirstName(),
                employerRequest.getLastName(), employerRequest.getEmail());
        employer.setPassword(employerRequest.getPassword());
        employerRepository.save(employer);
        return new EmployerResponse(employer.getId(), employer.getLogin(), employer.getEmployerName(),
                employer.getFirstName(), employer.getLastName(), employer.getEmail());
    }

    public List<EmployerResponse> getAll() {
        return employerRepository.findAll().stream().map(employer -> new EmployerResponse(employer.getId(),
                employer.getLogin(), employer.getEmployerName(), employer.getFirstName(), employer.getLastName(),
                employer.getEmail())).collect(Collectors.toList());
    }

    public EmployerResponse getEmployerById(int id) {
        Employer employer = employerRepository.getById(id);
        return new EmployerResponse(employer.getId(), employer.getLogin(), employer.getEmployerName(),
                employer.getFirstName(), employer.getLastName(), employer.getEmail());
    }

    public EmployerResponse edit(int id, EmployerRequest employerRequest) throws HeadHunterException {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.EMPLOYER_NOT_EXIST));
        employer.setLogin(employerRequest.getLogin());
        employer.setPassword(employerRequest.getPassword());
        employer.setEmployerName(employerRequest.getEmployerName());
        employer.setFirstName(employerRequest.getFirstName());
        employer.setLastName(employerRequest.getLastName());
        employer.setEmail(employerRequest.getEmail());
        employerRepository.save(employer);
        return new EmployerResponse(employer.getId(), employer.getLogin(), employer.getEmployerName(),
                employer.getFirstName(), employer.getLastName(), employer.getEmail());
    }

    public void delete(int id) throws HeadHunterException {
        Employer employer = employerRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.EMPLOYER_NOT_EXIST));
        employerRepository.delete(employer);
    }
}