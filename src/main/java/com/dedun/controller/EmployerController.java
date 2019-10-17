package com.dedun.controller;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.dto.response.EmployerResponse;
import com.dedun.exception.HeadHunterException;
import com.dedun.service.EmployerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    private final EmployerService employerService;

    public EmployerController(EmployerService employerService) {
        this.employerService = employerService;
    }

    @PostMapping("/registration")
    public EmployerResponse registerEmployer(@RequestBody EmployerRequest employerRequest) throws HeadHunterException {
        return employerService.saveEmployer(employerRequest);
    }

    @GetMapping
    public List<EmployerResponse> getAll(){
        return employerService.getAll();
    }

    @GetMapping(value = "{id}")
    public EmployerResponse getEmployerById(@PathVariable(value = "id") int id){return employerService.getEmployerById(id);}

    @PutMapping(value = "{id}")
    public EmployerResponse edit(@PathVariable(value = "id") int id, @RequestBody EmployerRequest employerRequest) throws HeadHunterException {
        return employerService.edit(id,employerRequest);
    }

    @DeleteMapping(value = "{id}")
    public void delete(@PathVariable(value = "id") int id) throws HeadHunterException {
        employerService.delete(id);
    }
}


