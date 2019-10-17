package com.dedun.controller;

import com.dedun.dto.request.VacanciesRequest;
import com.dedun.dto.response.VacanciesResponse;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Vacancies;
import com.dedun.service.VacanciesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vacancies")
public class VacanciesController {
    private final VacanciesService vacanciesService;

    public VacanciesController(VacanciesService vacanciesService) {
        this.vacanciesService = vacanciesService;
    }

    @PostMapping(value = "{id}")
    public VacanciesResponse create(@PathVariable(value = "id") int id, @RequestBody VacanciesRequest vacanciesRequest) throws HeadHunterException {
        return vacanciesService.create(vacanciesRequest, id);
    }

    @GetMapping
    public List<VacanciesResponse> getAll() {
        return vacanciesService.getAll();
    }

    @GetMapping(value = "{id}")
    public VacanciesResponse getVacancyById(@PathVariable(value = "id") int id) {
        return vacanciesService.getVacancyById(id);
    }

    @PutMapping(value = "{id}")
    public VacanciesResponse edit(@PathVariable(value = "id") int id, @RequestBody VacanciesRequest vacanciesRequest) throws HeadHunterException {
        return vacanciesService.edit(vacanciesRequest, id);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") int id) throws HeadHunterException {
        vacanciesService.delete(id);
    }

}
