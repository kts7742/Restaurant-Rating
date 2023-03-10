/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.example.demo.commands.CommandRegistry;
import com.example.demo.entities.Resto;
import com.example.demo.entities.Review;
import com.example.demo.entities.User;
import com.example.demo.repositories.IRestoRepository;
import com.example.demo.repositories.IReviewRepository;
import com.example.demo.repositories.IUserRepository;
import com.example.demo.repositories.RestoRepository;
import com.example.demo.repositories.ReviewRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.RestoService;
import com.example.demo.services.ReviewService;
import com.example.demo.services.UserService;

public class App {

    public static void main(String[] args) {
        if (args.length != 1){
            throw new RuntimeException();
        }
        List<String> commandLineArgs = new LinkedList<>(Arrays.asList(args));
        run(commandLineArgs);
    }

    public static void run(List<String> commandLineArgs){

        IUserRepository userRepository = new UserRepository();
		IRestoRepository restoRepository = new RestoRepository();
        IReviewRepository reviewRepository = new ReviewRepository();
        

        // Initialize services
        UserService userService = new UserService(userRepository);
        RestoService restoService = new RestoService(restoRepository);
        ReviewService reviewService = new ReviewService(reviewRepository, restoRepository, userRepository);
     
        String inputFile = commandLineArgs.get(0).split("=")[1];

        try(BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (true) {
                String line = reader.readLine();
                if (line == null){
                    break;
                }
                List<String> tokens = Arrays.asList(line.split(" "));

                // Execute Services
                switch(tokens.get(0)){
					case "REGISTER_USER":
					{
                        String name = tokens.get(1);
                        User user = userService.addUser(name);
                        System.out.println(user);                
					}
					break;
                    case "REGISTER_RESTAURANT":
					{
                        String name = tokens.get(1);
                        Resto resto = restoService.addResto(name);
                        System.out.println(resto);                
					}
					break;
                    case "ADD_RATING":
					{
                        int rating = Integer.parseInt(tokens.get(1));
                        Long userId = Long.parseLong(tokens.get(2));
                        Long restoId = Long.parseLong(tokens.get(3));
                        Review review = reviewService.addReview(rating, userId, restoId);
                        System.out.println(review);                
					}
					break;

                    case "GET_REVIEWS":
					{
                        Long restoId = Long.parseLong(tokens.get(1));
                        String order = tokens.get(2);
                        String message = reviewService.getReviewOrder(restoId, order);
                        System.out.println(message);                
					}
					break;

                    case "DESCRIBE_RESTAURANT":
					{
                            Long restoId = Long.parseLong(tokens.get(1));
							String message = restoService.getRestoById(restoId);
							System.out.println(message);

					}
                    break;

                    case "LIST_RESTAURANT":
					{
							List<Resto> rList = restoService.getResto();
							System.out.println(rList);

					}
                    break;

                    case "GET_REVIEWS_FILTER_ORDER":
					{
                        Long restoId = Long.parseLong(tokens.get(1));
                        int low = Integer.parseInt(tokens.get(2));
                        int high = Integer.parseInt(tokens.get(3));
                        String order = tokens.get(4);
                        String message = reviewService.getReviewOrderBy(restoId, low, high, order);
                        System.out.println(message);                
					}
					break;
                    // default:
                    //     throw new RuntimeException("Invalid Command");
                }
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
