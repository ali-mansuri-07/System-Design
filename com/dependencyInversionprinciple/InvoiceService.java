package com.dependencyInversionprinciple;

public class InvoiceService {
    private InvoiceRepository repository;

    public InvoiceService(InvoiceRepository repository) {
        this.repository = repository;
    }

    public void saveInvoice(Invoice invoice) {
        repository.save(invoice);
    }
}