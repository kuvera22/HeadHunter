package com.dedun.service;

import com.dedun.dto.request.WorkerRequest;
import com.dedun.dto.response.WorkerResponse;
import com.dedun.exception.HeadHunterErrorCode;
import com.dedun.exception.HeadHunterException;
import com.dedun.model.Worker;
import com.dedun.repository.WorkerRepository;
import com.dedun.validator.WorkerValidator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WorkerService {

    private final WorkerRepository workerRepository;
    private final WorkerValidator workerValidator;

    public WorkerService(WorkerRepository workerRepository, WorkerValidator workerValidator) {
        this.workerRepository = workerRepository;
        this.workerValidator = workerValidator;
    }


    public WorkerResponse saveWorker(WorkerRequest workerRequest) throws HeadHunterException {
        workerValidator.checkWorkerAlreadyExist(workerRequest);
        Worker worker = new Worker(workerRequest.getLogin(), null, workerRequest.getFirstName(), workerRequest.getLastName(), workerRequest.getEmail());
        worker.setPassword(workerRequest.getPassword());
        workerRepository.save(worker);
        return new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail());
    }

    public List<WorkerResponse> getAll() {
        return workerRepository.findAll().stream().map(worker -> new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail())).collect(Collectors.toList());
    }

    public WorkerResponse getWorkerById(int id) {
        Worker worker = workerRepository.getById(id);
        return new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail());
    }

    public WorkerResponse edit(int id, WorkerRequest workerRequest) throws HeadHunterException {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.WORKER_NOT_EXIST));
        worker.setLogin(workerRequest.getLogin());
        worker.setEmail(workerRequest.getEmail());
        worker.setFirstName(workerRequest.getFirstName());
        worker.setLastName(workerRequest.getLastName());
        worker.setPassword(workerRequest.getPassword());
        workerRepository.save(worker);
        return new WorkerResponse(worker.getId(), worker.getLogin(), worker.getFirstName(), worker.getLastName(), worker.getEmail());
    }

    public void delete(int id) throws HeadHunterException {
        Worker worker = workerRepository.findById(id).orElseThrow(() -> new HeadHunterException(HeadHunterErrorCode.WORKER_NOT_EXIST));
        workerRepository.delete(worker);
    }
}
