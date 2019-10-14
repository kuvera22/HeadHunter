package com.dedun.validator;

import com.dedun.dto.request.EmployerRequest;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Employer;
import com.dedun.repository.EmployerRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployerValidator {
    private final EmployerRepository employerRepository;

    public EmployerValidator(EmployerRepository employerRepository) {
        this.employerRepository = employerRepository;
    }

    public void checkEmployerAlreadyExist(EmployerRequest employerRequest) throws HeadHunterException {
        if (employerRepository.getByLogin(employerRequest.getLogin()) != null)
            throw new HeadHunterException(HeadHunterErrorCode.EMPLOYER_EXIST);
    }

    public void checkEmployerExist(Employer employer) throws HeadHunterException {
        if (employer == null)
            throw new HeadHunterException(HeadHunterErrorCode.EMPLOYER_NOT_EXIST);
    }
}
