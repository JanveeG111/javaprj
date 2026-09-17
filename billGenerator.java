
import java.util.*;
public class billGenerator {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	       
	        Map<String, Double> priceList = new LinkedHashMap<>();
	        priceList.put("Pen", 10.0);
	        priceList.put("Pencil", 5.0);
	        priceList.put("Notebook", 40.0);
	        priceList.put("Eraser", 3.0);
	        priceList.put("Scale", 7.0);
	        priceList.put("Sharpener", 4.0);
	        priceList.put("Marker", 15.0);
	        priceList.put("Highlighter", 20.0);
	        priceList.put("Stapler", 50.0);
	        priceList.put("Staple Pins", 10.0);
	        priceList.put("Glue Stick", 25.0);
	        priceList.put("Scissors", 35.0);
	        priceList.put("File", 12.0);
	        priceList.put("Sticky Notes", 18.0);
	        priceList.put("Paper Clips", 6.0);
	        priceList.put("Board Pins", 8.0);
	        priceList.put("Envelope", 5.0);
	        priceList.put("Brown Sheet", 10.0);
	        priceList.put("Chart Paper", 12.0);
	        priceList.put("Drawing Book", 45.0);
	        priceList.put("Geometry Box", 60.0);
	        priceList.put("Calculator", 150.0);

	        Map<String, Integer> quantityMap = new LinkedHashMap<>();

	        System.out.println("\n📚 Welcome to Rithu's Stationery Shop");
	        System.out.println("==============================================");
	        System.out.printf("%-20s %-10s%n", "Item", "Price (₹)");
	        System.out.println("----------------------------------------------");

	        // Print available items in a neat table
	        for (Map.Entry<String, Double> entry : priceList.entrySet()) {
	            System.out.printf("%-20s ₹%-10.2f%n", entry.getKey(), entry.getValue());
	        }

	        System.out.println("==============================================");

	        // User input loop
	        String choice;
	        do {
	            System.out.print("\nEnter item name to add (or 'done' to finish): ");
	            String item = sc.nextLine();

	            if (item.equalsIgnoreCase("done")) break;

	            if (priceList.containsKey(item)) {
	                System.out.print("Enter quantity for " + item + ": ");
	                int qty = Integer.parseInt(sc.nextLine());
	                quantityMap.put(item, quantityMap.getOrDefault(item, 0) + qty);
	            } else {
	                System.out.println("❌ Item not found! Please enter a valid item name from the list.");
	            }

	        } while (true);

	        System.out.println("\n🧾 Final Bill:");
	        System.out.println("-----------------------------------------------------");
	        System.out.printf("%-20s %-10s %-10s%n", "Item", "Qty", "Total (₹)");
	        System.out.println("-----------------------------------------------------");

	        double total = 0.0;
	        for (String item : quantityMap.keySet()) {
	            int qty = quantityMap.get(item);
	            double price = priceList.get(item);
	            double itemTotal = qty * price;
	            total += itemTotal;
	            System.out.printf("%-20s %-10d ₹%-10.2f%n", item, qty, itemTotal);
	        }

	        double gst = total * 0.05; // 5% GST
	        double grandTotal = total + gst;

	        System.out.println("-----------------------------------------------------");
	        System.out.printf("%-30s ₹%-10.2f%n", "Subtotal", total);
	        System.out.printf("%-30s ₹%-10.2f%n", "GST (5%)", gst);
	        System.out.printf("%-30s ₹%-10.2f%n", "Grand Total", grandTotal);
	        System.out.println("=====================================================");
	        System.out.println("🙏 Thank you for shopping with us!");
	        sc.close();
	    }
}