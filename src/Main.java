import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffleCards();
        Player gabrion = new Player("Gabrion");
        Player raishun = new Player("Raishun");
        Scanner userInput = new Scanner(System.in);
        boolean keepPlaying = true;


        while(keepPlaying) {

            System.out.println("Welcome to my blackjack game foo.");
            System.out.println("Here comes your cards: ");

            for (int i = 0; i < 4; i++) {
                if (i == 0 || i == 2) {
                    gabrion.giveCard(deck.dealCard());
                } else {
                    raishun.giveCard(deck.dealCard());
                    
                }
            }
            System.out.println("Gabrion's hand: \n");
                gabrion.showCards();
            System.out.println("\nRaishun's hand: \n");
                raishun.showCards();

                while (gabrion.getCurrentTotal() <= 21) {
                    System.out.printf("\nGabrion's Current Total: %s", gabrion.getCurrentTotal());
                System.out.println("\nGabrion, do you want to hit or stay?");
                String answer = userInput.nextLine();


                if(answer.equals("hit")){

                    gabrion.giveCard(deck.dealCard());
                    gabrion.showCards();
                } else {
                    break;
                }
            }
            System.out.println("Current Total: \n" + gabrion.getCurrentTotal());

            while (raishun.getCurrentTotal() <= 21) {
                System.out.printf("\nRaishun's Current Total: %s", raishun.getCurrentTotal());
                System.out.println("\nRaishun, do you want to hit or stay?");
                String answer = userInput.nextLine();


            if(answer.equals("hit")){

                raishun.giveCard(deck.dealCard());
                raishun.showCards();
            } else {
                break;
            }
        }
        System.out.println("Current Total: \n" + raishun.getCurrentTotal());


        if (raishun.getBroke() || gabrion.getCurrentTotal() > raishun.getCurrentTotal() && !gabrion.getBroke()) {
            System.out.println("Gabrion wins\n");            
        } else if (gabrion.getBroke() || raishun.getCurrentTotal() < gabrion.getCurrentTotal() && !raishun.getBroke()) {
            System.out.println("Raishun wins\n");            
        } else{
            System.out.println("Looks like a tie my dawg \n");
        }
                keepPlaying = false;
        }

    }
}
