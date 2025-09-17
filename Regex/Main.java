package Regex;

public class Main {
    public static void main(String[] args) {
        DealManager<Deal> manager = new DealManager<>();

        manager.addDeal("D100", "Get 25% OFF, valid till 20-08-2025", new Deal("D100", "Get 25% OFF, valid till 20-08-2025"));
        manager.addDeal("D101", "Flat 15% discount valid till 01-08-2025", new Deal("D101", "Flat 15% discount valid till 01-08-2025"));
        manager.addDeal("D102", "Limited Offer: 30% valid till 15-08-2025", new CashbackDeal("D102", "Limited Offer: 30% valid till 15-08-2025"));
        manager.addDeal("D103", "Get 20% OFF, expires 01-07-2025", new ReferralBonusDeal("D103", "Get 20% OFF, expires 01-07-2025")); // Expired

        manager.printDeals();
    }
}

