package com.tutrit.stoservice.controller;

import com.tutrit.stoservice.repository.CarRepository;

public class RepositoryCarControllerSpy extends RepositoryCarController {

    public int numSaveCarToRepCalled = 0;
    public Request capturedRequest;

    public RepositoryCarControllerSpy(final CarRepository repository) {
        super(repository);
    }

    @Override
    public void doCommand(final Request request, final Response response) {
        super.doCommand(request, response);
    }

    @Override
    protected void saveCarToRep(final Request request) {
        numSaveCarToRepCalled++;
        captrure(request);
        super.saveCarToRep(request);
    }

    private void captrure(Request request) {
        Request captured = new Request(request.getCommand());
        captured.setInformation(request.getInformation());
        capturedRequest = captured;
    }
}
