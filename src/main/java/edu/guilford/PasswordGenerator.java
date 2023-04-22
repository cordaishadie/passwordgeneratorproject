package edu.guilford;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class PasswordGenerator 
{
    public static void main( String[] args )
    {
        Scanner keyboard = new Scanner(System.in);
       
        // Create a User object
        User user = new User();

        // Ask the user for their first name 
        System.out.println( "Enter your first name: " );
        String firstName = keyboard.nextLine();
        // Set the user's first name
        user.setFirstName(firstName);

        // Ask the user for their last name and set it
        System.out.println( "Enter your last name: " );
        String lastName = keyboard.nextLine();
        user.setLastName(lastName);

        // Ask the user for their email address and set it
        System.out.println( "Enter your email address: " );
        String email = keyboard.nextLine();
        user.setEmail(email);

        // Ask the user for their favorite color and set it
        System.out.println( "Enter your favorite color: " );
        String favoriteColor = keyboard.nextLine();
        user.setFavoriteColor(favoriteColor);

        // Ask the user for their first pet's name and set it
        System.out.println( "Enter your first pet's name: " );
        String firstPet = keyboard.nextLine();
        user.setFirstPet(firstPet);

        // Ask the user for their birth year and set it
        System.out.println( "Enter your birth year: " );
        int birthYear = keyboard.nextInt();
        user.setBirthYear(birthYear);

        // Use the generatePassword method to generate a password and set it
        String password = user.generatePassword();
        user.setPassword(password);
        // Print the password to the console
        System.out.println(user.getFirstName() + ", " + "your password is: " + password);

        // Use the encryptPassword method to encrypt the password and print it
        String encrypted = user.encryptPassword();
        // set the encrypted password
        user.setEncryptedPassword(encrypted);
        // Print the encrypted password to the console
        System.out.println(user.getFirstName() + ", " + "your encrypted password is: " + encrypted);
        // Then, you can use AES.decrypt to decrypt the encrypted password:
        String decrypted = AES.decrypt(encrypted, "asecretkey");
        // Print the decrypted password to the console
        System.out.println(user.getFirstName() + ", " + "your decrypted password is: " + decrypted);
        System.out.println("");


        // Instiate another user object using the scanner
        User user2 = new User();
        
        System.out.println("Enter your first name: ");
        String firstName2 = keyboard.nextLine();
        user2.setFirstName(keyboard.nextLine());

        System.out.println("Enter your last name: ");
        String lastName2 = keyboard.nextLine();
        user2.setLastName(lastName2);

        System.out.println("Enter your email address: ");
        String email2 = keyboard.nextLine();
        user2.setEmail(email2);

        System.out.println("Enter your favorite color: ");
        String favoriteColor2 = keyboard.nextLine();
        user2.setFavoriteColor(favoriteColor2);

        System.out.println("Enter your first pet's name: ");
        String firstPet2 = keyboard.nextLine();
        user2.setFirstPet(firstPet2);

        System.out.println("Enter your birth year: ");
        int birthYear2 = keyboard.nextInt();
        user2.setBirthYear(birthYear2);

        String password2 = user2.generatePassword();
        user2.setPassword(password2);
        System.out.println(user2.getFirstName() + ", " + "your password is: " + password2);
  
        // Use the encryptPassword method to encrypt the password and print it
        String encrypted2 = user2.encryptPassword();
        // set the encrypted password
        user2.setEncryptedPassword(encrypted2);
        // Print the encrypted password to the console
        System.out.println(user2.getFirstName() + ", " + "your encrypted password is: " + encrypted2);
        // Then, you can use AES.decrypt to decrypt the encrypted password:
        String decrypted2 = AES.decrypt(encrypted2, "asecretkey");
        // Print the decrypted password to the console
        System.out.println(user2.getFirstName() + ", " + "your decrypted password is: " + decrypted2);



    }
}
