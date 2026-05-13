// Class 3: Only database responsibility
class InvoiceRepository {
    private Invoice invoice;

    InvoiceRepository(Invoice invoice) {
        this.invoice = invoice;
    }

    public void save() {
        // Only DB logic lives here
        System.out.println("Saving [" + invoice.getItemName() + "] to database...");
    }
}
