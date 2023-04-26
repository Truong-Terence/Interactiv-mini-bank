package org.example;

import java.util.Scanner;

public class BankInteraction {
        private Scanner scanner;
        private Bank bank;

        public BankInteraction() {
            this.scanner = new Scanner(System.in);
            this.bank = new Bank("BNP");
        }

        public void interaction() {
            System.out.println();
            System.out.println("Quelle opération voulez-vous effectuer ?");
            System.out.println("1) Ajouter un client");
            System.out.println("2) Effectuer une operation sur un client");
            System.out.println("3) Afficher un bilan général");
            System.out.println("4) Quitter");
            int choice = this.scanner.nextInt();

            switch (choice) {
                case 1:
                    interactionAjoutClient();
                    break;
                case 2:
                    interactionCustomerOperation();
                    break;
                case 3:
                    interactionDisplayBalance();
                    break;
                case 4:
                    interactionStop();
                    break;
                default:
                    System.out.println("Votre choix n'existe pas. Veuillez recommencer");
                    interaction();
            }
        }

        private void interactionStop() {
            this.scanner.close();
            System.out.println("Merci et à bientôt");
            System.exit(0);
        }

        private void interactionDisplayBalance() {
            this.bank.displayBalanceSheet();
        }

        private void interactionCustomerOperation() {
            System.out.println("Quel client ?");

            Customer[] customers = this.bank.getCustomer();
            for (int i = 0; i < customers.length; i++) {
                Customer c = customers[i];
                if (c != null) {
                    System.out.println(i + 1 + ")" + c.getName());
                }
            }
            System.out.println("#############");
            int indexCustomer = this.scanner.nextInt();
            Customer customer = customers[indexCustomer - 1];
            interactionDisplayBalance();
        }

        private void interactionOperationMenuClient(Customer customer) {
            System.out.println();
            System.out.println("Quelle operation voulez-vous effectuer sur le client " + customer.getName() + " ?");
            System.out.println("1) Ajouter un compte");
            System.out.println("2) Afficher un bilan");
            System.out.println("3) Faire un retrait");
            System.out.println("4) Faire un dépôt");
            System.out.println("5) Faire un virement");
            System.out.println("6) Quitter");
            int choice = this.scanner.nextInt();
            switch (choice) {
                case 1:
                    customer.addAccount(50);
                    System.out.println("Un compte a été ajouté au client " + customer.getName());
                    break;
                case 2:
                    customer.displayBalance();
                    break;
                case 3:
                    System.out.println("Sur quel compte voulez-vous retirer de l'argent ?");
                    Account AccountDebit = selectionCompte(customer);
                    System.out.println("Quel montant voulez-vous retirer ?");
                    float valeur = this.scanner.nextFloat();
                    AccountDebit.withdrawal(valeur);
                    System.out.println(valeur + " a été retiré du compte " + AccountDebit.getAccountId());
                    customer.displayBalance();
                    break;
                case 4:
                    System.out.println("Sur quel compte voulez-vous déposer de l'argent ?");
                    Account compteCredit = selectionCompte(customer);
                    System.out.println("Quel montant voulez-vous déposer ?");
                    valeur = this.scanner.nextFloat();
                    compteCredit.deposit(valeur);
                    System.out.println(valeur + " a été déposé sur le compte " + compteCredit.getAccountId());
                    customer.displayBalance();
                    break;
                case 5:
                    System.out.println("Depuis quel compte voulez-vous retirer l'argent ?");
                    AccountDebit = selectionCompte(customer);
                    System.out.println("Vers quel compte voulez-vous envoyer l'argent ?");
                    Account compteDestination = selectionCompte(customer);
                    System.out.println("Quel montant voulez-vous utiliser pour le virement ?");
                    valeur = this.scanner.nextFloat();
                    AccountDebit.transfer(valeur, compteDestination);
                    System.out.println(valeur + " a été déposé sur le compte " + compteDestination.getAccountId());
                    customer.displayBalance();
                    break;
                case 6:
                    interactionStop();
                    break;
                default:
                    System.out.println("Votre choix n'existe pas. Veuillez recommencer");
                    interactionOperationMenuClient(customer);
                    break;
            }
            System.out.println("1) Revenir au menu principal");
            System.out.println("2) Revenir au menu operation sur client");
            System.out.println("3) Quitter");
            int choixInteraction = this.scanner.nextInt();
            switch (choixInteraction) {
                case 1:
                    interaction();
                    break;
                case 2:
                    interactionCustomerOperation();
                    break;
                case 3:
                default:
                    interactionStop();
            }
        }

        private Account selectionCompte(Customer customer) {
            for (Account account : customer.getAccounts()) {
                if (account != null) {
                    System.out.println(account.getAccountId() + ") Compte nº " + account.getAccountId());
                }
            }
            int numeroCompte = this.scanner.nextInt();
            return customer.getAccounts()[numeroCompte - 1];
        }

        private void interactionAjoutClient() {
            System.out.println("Entrez le nom du client :");
            String customerName = this.scanner.next();
            this.bank.addCustomer(customerName);
            System.out.println("Le client " + customerName + " a été créé");
            interaction();
        }
}