package com.techcrack.DSA.lesson2;

import java.util.Random;
import java.util.Scanner;

public class GreetingMessage {

    //user given a name we needed to give a unique greeting message for every name
    public static void main(String[] args){
        //Scanner Object->Input
        Scanner scan=new Scanner(System.in);
        greeting(scan);
    }

    private static void greeting(Scanner scan){
        String[] greet={
                "Hi there1","Hello!","Hey","Good morning!","Good afternoon!","Good evening!","Greetings!",
                "Howdy","Salutations!","Hiya!","What's up!","How's it going!","Yo!","Hi friend!","Welcome","Hi,","Aloha!",
                "Bonjour!","Ciao!","Namaste!","Hola!","Sup!","How are you?","Nice to see you!","Hey,What's new?","How have you been?"
        };
        Random ran=new Random();
        String name=scan.nextLine();
        System.out.println(name+" "+greet[ran.nextInt(26)]);
    }
}
