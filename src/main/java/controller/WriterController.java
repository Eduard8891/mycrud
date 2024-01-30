package controller;

import model.Writer;
import repository.GsonWriterRepositoryImpl;
import repository.WriterRepository;

import java.util.List;

public class WriterController {
    private final WriterRepository writerRepository;

    public WriterController() {
        this.writerRepository = new GsonWriterRepositoryImpl();
    }

    public List<Writer> getAll(String line) {
        return null;
    }

    public void createWriter(String line) {
    }

    public void updateWriter(String line) {
    }

    public Writer showWriter(String line) {
        return new Writer();
    }

    public void deleteWriter(String line) {
    }
}
