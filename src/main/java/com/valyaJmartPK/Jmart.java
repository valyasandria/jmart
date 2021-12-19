package com.valyaJmartPK;

import com.valyaJmartPK.dbjson.JsonDBEngine;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class to run front end
 *
 * @author Valya Sandria Akiela
 * @version 1.0
 */

@SpringBootApplication
class Jmart
{
     public static void main(String[] args)
     {
         JsonDBEngine.Run(Jmart.class);
         SpringApplication.run(Jmart.class, args);
         Runtime.getRuntime().addShutdownHook(new Thread(()->JsonDBEngine.join()));
     }
}
