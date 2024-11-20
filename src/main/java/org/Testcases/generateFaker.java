	package org.Testcases;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Set;
import com.github.javafaker.Faker;

public class generateFaker {
    
    public Faker faker = new Faker(); // Instantiate Faker here

    public String generateValidBankName(Faker faker, Set<String> existingBankNames) {
        String bankName;
        int attempts = 0;
        final int maxAttempts = 100;

        do {
            // Generate a bank name pattern with uppercase letters followed by "BANK"
            bankName = faker.regexify("[A-Z]{3,5} BANK");
            attempts++;

            // Check if max attempts have been reached
            if (attempts >= maxAttempts) {
                throw new IllegalStateException("Unable to generate a unique valid bank name after " + maxAttempts + " attempts");
            }
        } while (!isValidBankName(bankName, existingBankNames));

        // Store the valid bank name in the set to avoid future duplicates
        existingBankNames.add(bankName);
        return bankName;
    }

    private boolean isValidBankName(String bankName, Set<String> existingBankNames) {
        if (bankName.length() < 8 || bankName.length() > 10) { // Check length for pattern "XXX BANK" to "XXXXX BANK"
            return false;
        }
        String baseName = bankName.toUpperCase();
        if (existingBankNames.contains(baseName)) { // Check for exact duplicate
            return false;
        }
        return bankName.matches("[A-Z]{3,5} BANK"); // Check if the name matches the pattern
    }
    
    public String generateRandomAddress() {
        String houseNumber = faker.number().numberBetween(1, 100) + "/A"; // Generate a random house number (e.g., "67/A")
        
        // Generate a random street name with uppercase letters and digits only, no special characters
        String streetName = faker.address().streetName()
                                  .replaceAll("[^A-Z0-9]", ""); // Remove all special characters
        // Ensure that the street name starts with an uppercase letter
        streetName = streetName.length() > 0 ? Character.toUpperCase(streetName.charAt(0)) + streetName.substring(1) : "";

        // Generate a random city name with uppercase letters and digits only, no special characters
        String cityName = faker.address().city()
                               .replaceAll("[^A-Z0-9]", ""); // Remove all special characters
        // Ensure that the city name starts with an uppercase letter
        cityName = cityName.length() > 0 ? Character.toUpperCase(cityName.charAt(0)) + cityName.substring(1) : "";

        return houseNumber + ", " + streetName + ", " + cityName;
    }

    public String generateValidPAN() {
        StringBuilder pan = new StringBuilder();
        for (int i = 0; i < 5; i++) { // First 5 characters: Uppercase letters
            pan.append(faker.regexify("[A-Z]")); // Generate uppercase letter
        }
        for (int i = 0; i < 4; i++) { // Next 4 characters: Digits
            pan.append(faker.number().numberBetween(0, 10)); // Generate digit
        }
        pan.append(faker.regexify("[A-Z]")); // Last character: Uppercase letter
        return pan.toString();
    }

    public String generateValidGST() {
        StringBuilder gst = new StringBuilder();

        // First 2 characters: State code (01 to 37, 38 for center)
        int stateCode = faker.number().numberBetween(1, 38);
        gst.append(String.format("%02d", stateCode)); // Format to ensure 2 digits

        // Next 10 characters: PAN format (5 letters, 4 digits, 1 letter)
        gst.append(faker.regexify("[A-Z]{5}")); // 5 letters
        gst.append(faker.number().digits(4)); // 4 digits
        gst.append(faker.regexify("[A-Z]")); // 1 letter

        // 13th character: Entity type code - use "1" as standard
        gst.append("1");

        // 14th character: Default to "Z"
        gst.append("Z");

        // 15th character: Checksum calculation
        gst.append(calculateChecksum(gst.toString()));

        return gst.toString();
    }

    // Method to calculate checksum for GST number
    private char calculateChecksum(String gstWithoutChecksum) {
        String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        int factor = 1, sum = 0;
        for (int i = 0; i < gstWithoutChecksum.length(); i++) {
            int codePoint = alphabet.indexOf(gstWithoutChecksum.charAt(i));
            factor = (i % 2 == 0) ? 1 : 2; // Weight factor: 1 for even index, 2 for odd index
            int addend = factor * codePoint;
            addend = (addend / 36) + (addend % 36); // Reduce to single digit if > 36
            sum += addend;
        }
        int checksumIndex = (36 - (sum % 36)) % 36; // Calculate checksum
        return alphabet.charAt(checksumIndex);
    }
    
    private Random random = new Random();

    public String generateRandomName() {
        // Generate a random length between 7 and 9
        int length = random.nextInt(3) + 7; // Generates either 7, 8, or 9
        StringBuilder name = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            char randomChar = (char) ('A' + random.nextInt(26)); // Generates a random uppercase letter
            name.append(randomChar);
        }
        return name.toString();
    }
    
    
    public String generateMobileNumber() {
        // Generate the first digit (6 to 9)
        int firstDigit = random.nextInt(4) + 6; // Generates either 6, 7, 8, or 9
        StringBuilder mobileNumber = new StringBuilder();
        
        // Append the first digit
        mobileNumber.append(firstDigit);
        
        // Generate the next 9 digits
        for (int i = 0; i < 9; i++) {
            int nextDigit = random.nextInt(10); // Generates a digit between 0 and 9
            mobileNumber.append(nextDigit);
        }
        
        return mobileNumber.toString();
    }
    
    public String generateEmail() {
        // Generate a random username
        String username = generateRandomUsername();

        // Use a fixed domain
        String domain = "gmail.com";

        // Combine to form the email
        return username + "@" + domain;
    }

    private String generateRandomUsername() {
        // Generate a random length between 5 and 10 for the username
        int length = random.nextInt(6) + 5; // Generates a length from 5 to 10
        StringBuilder username = new StringBuilder();

        // Generate the username with letters and numbers only
        for (int i = 0; i < length; i++) {
            // Randomly decide whether to add a letter or a number
            if (random.nextBoolean()) {
                // Add a letter (a-z)
                char letter = (char) (random.nextInt(26) + 'a'); // Lowercase letters
                username.append(letter);
            } else {
                // Add a digit (0-9)
                int digit = random.nextInt(10);
                username.append(digit);
            }
        }

        return username.toString();
    }
    
//    public String generateValidUniqueReferenceNumber(Faker faker, Set<String> existingBankNames) {
//        String uniqueReferenceNumber;
//        int maxRetries = 100; // Limit retries to avoid infinite loop
//        int attempts = 0;
//
//        while (attempts < maxRetries) {
//            // Generate a 10-character alphanumeric string
//            uniqueReferenceNumber = faker.regexify("[A-Za-z0-9]{10}");
//
//            // Check if the generated reference number is different from the existing one
//            // and does not exist in the existingBankNames set
//            if ((uniqueReferenceNumber == null || !uniqueReferenceNumber.equals(uniqueReferenceNumber))
//                    && !existingBankNames.contains(uniqueReferenceNumber)) {
//                return uniqueReferenceNumber; // Return unique reference number if it's valid
//            }
//
//            attempts++; // Increment attempt counter
//        }
//
//        throw new RuntimeException("Unable to generate a unique reference number after " + maxRetries + " attempts.");
//    }
    
    
    public String generateValidUniqueReferenceNumber(Faker faker, Set<String> existingUniqueReferenceNumbers) {
        String uniqueReferenceNumber;
        
        // Keep generating until we get a unique reference number
        do {
            uniqueReferenceNumber = faker.regexify("[A-Za-z0-9]{10}");
        } while (existingUniqueReferenceNumbers.contains(uniqueReferenceNumber));
        
        // Add the unique reference number to the set
        existingUniqueReferenceNumbers.add(uniqueReferenceNumber);
        
        return uniqueReferenceNumber;
    }


    
    public String generateValidBankAccountNumber() {
        StringBuilder accountNumber = new StringBuilder();

        // SBI account numbers are usually 11 digits long
        for (int i = 0; i < 11; i++) {
            // Generate a random digit (0-9)
            int digit = random.nextInt(10);
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }
    
    public String generateValidAggregatorCode() {
        StringBuilder codeBuilder = new StringBuilder(6);
        for (int i = 0; i < 6; i++) {
            // Generate a random alphanumeric character
            char character;
            if (random.nextBoolean()) {
                // Generate a random letter (A-Z or a-z)
                character = (char) (random.nextBoolean() ? 'A' + random.nextInt(26) : 'a' + random.nextInt(26));
            } else {
                // Generate a random digit (0-9)
                character = (char) ('0' + random.nextInt(10));
            }
            codeBuilder.append(character);
        }
        return codeBuilder.toString();
}
    
    
    public String generateValidAadhaar(Faker faker, Set<String> existingAadhaarNumbers) {
		String aadhaarNumber;

		// Continuously generate Aadhaar numbers until a unique and valid one is found
		do {
			StringBuilder aadhaarBuilder = new StringBuilder();

			// Ensure the first digit is NOT 0 or 1
			aadhaarBuilder.append(faker.number().numberBetween(2, 10)); // First digit: 2 to 9

			// Generate the next 10 digits randomly (digits between 0 and 9)
			for (int i = 1; i < 11; i++) {
				aadhaarBuilder.append(faker.number().numberBetween(0, 10)); // Digits between 0 and 9
			}

			// Generate the 12th digit (check digit) using the Verhoeff algorithm
			int checkDigit = calculateVerhoeffCheckDigit(aadhaarBuilder.toString());
			aadhaarBuilder.append(checkDigit);

			// Final generated Aadhaar number
			aadhaarNumber = aadhaarBuilder.toString();

			// Check if the generated Aadhaar number is unique
		} while (existingAadhaarNumbers.contains(aadhaarNumber));

		// Add the newly generated Aadhaar number to the set to track it
		existingAadhaarNumbers.add(aadhaarNumber);

		return aadhaarNumber;
	}

	// Verhoeff algorithm for check digit calculation (same as before)
    public static final int[][] verhoeffMultiplicationTable = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 1, 2, 3, 4, 0, 6, 7, 8, 9, 5 }, { 2, 3, 4, 0, 1, 7, 8, 9, 5, 6 }, { 3, 4, 0, 1, 2, 8, 9, 5, 6, 7 },
			{ 4, 0, 1, 2, 3, 9, 5, 6, 7, 8 }, { 5, 9, 8, 7, 6, 0, 4, 3, 2, 1 }, { 6, 5, 9, 8, 7, 1, 0, 4, 3, 2 },
			{ 7, 6, 5, 9, 8, 2, 1, 0, 4, 3 }, { 8, 7, 6, 5, 9, 3, 2, 1, 0, 4 }, { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 } };

    public static final int[][] verhoeffPermutationTable = { { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 },
			{ 1, 5, 7, 6, 2, 8, 3, 0, 9, 4 }, { 5, 8, 0, 3, 7, 9, 6, 1, 4, 2 }, { 8, 9, 1, 6, 0, 4, 3, 5, 2, 7 },
			{ 9, 4, 5, 3, 1, 2, 6, 8, 7, 0 }, { 4, 2, 8, 6, 5, 7, 3, 9, 0, 1 }, { 2, 7, 9, 3, 8, 0, 6, 4, 1, 5 },
			{ 7, 0, 4, 6, 9, 1, 3, 2, 5, 8 } };

    public static final int[] verhoeffInverseTable = { 0, 4, 3, 2, 1, 5, 6, 7, 8, 9 };

	// Calculate Verhoeff check digit for the given number (11 digits for Aadhaar)
    public int calculateVerhoeffCheckDigit(String number) {
		int checkSum = 0;
		int[] digits = number.chars().map(c -> c - '0').toArray();

		for (int i = digits.length - 1, j = 0; i >= 0; i--, j++) {
			checkSum = verhoeffMultiplicationTable[checkSum][verhoeffPermutationTable[j % 8][digits[i]]];
		}
		
		return verhoeffInverseTable[checkSum];
	}
    
    public String generateIndianPassportNumber() {
        // Generate a passport number with one uppercase letter followed by 7 digits
    	 return faker.regexify("[A-PR-Y][1-9]{7}");
    }
    
    public String generateImage(String sheetName) {  
        // Placeholder API URL to get a random image (200x300)
        String imageUrl = "https://picsum.photos/200/300";
        
        // Generate a unique filename for the image based on the sheetName
        String saveDir = System.getProperty("user.home") + "/Pictures";
        String fileName = sheetName + "_RandomImage.jpg"; // Fixed filename for a single image
        String filePath = Paths.get(saveDir, fileName).toString();
        
        // Check if the file already exists to avoid multiple downloads
        File file = new File(filePath);
        if (file.exists()) {
            System.out.println("Image already exists: " + filePath);
            return filePath;
        }
        
        try (@SuppressWarnings("deprecation")
		BufferedInputStream in = new BufferedInputStream(new URL(imageUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(filePath)) {
            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
            System.out.println("Image downloaded to: " + filePath);
        } catch (IOException e) {
            System.err.println("Error downloading image: " + e.getMessage());
            return null;
        }
        
        return filePath;
    }


    }
    

