
public class MobilePhone {
  String BrandName;
  String Model;
  double Price;  
  public MobilePhone(  String Brand,String Model,  double Price){
this.BrandName = Brand;
this.Model= Model;
this.Price= Price;
  }
  public void displayDetails() {
        System.out.println("Brand Model  : " + Model);
        System.out.println("Brand Name  : " + BrandName);
        System.out.println("Brand Price : ₹" + Price);
}
public double calculateTotalCost(int quantity) {
        return Price * quantity;
    }
    public static void main(String[]args){
        MobilePhone phone = new MobilePhone("Samsung", "S23", 60000);

        phone.displayDetails();
        int quantity = 5;
        double TotalCost= phone.calculateTotalCost(quantity);
        System.out.println("Quantity     : " + quantity);
        System.out.println("Total Cost   : Rs" + TotalCost);
    }
}