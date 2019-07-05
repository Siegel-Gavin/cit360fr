package code.MVC;

public class CustomerController {
    private Customer model;
    private CustomerView view;

        public CustomerController(Customer model, CustomerView view){
            this.model = model;
            this.view = view;
        }

        public void setCustomerName(String name){
            model.setName(name);
        }

        public String getCustomereName(){
            return model.getName();
        }

        public void setaltID(String altID){
            model.setaltID(altID);
        }

        public String getaltID(){
            return model.getaltID();
        }

        public void updateView(){
            view.printCustomerDetails(model.getName(), model.getaltID());
        }
}
