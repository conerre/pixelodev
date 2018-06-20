//
//  Category.swift
//  Libreria_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 21/05/2018.
//  Copyright © 2018 pixelo.com.ar. All rights reserved.
//

import Foundation
class Category{
    var name : String
    var books : [Book]
    
    init(name:String, books:[Book]) {
        self.name = name
        self.books = []
        
    }
    
    
    init(dictionary: [String: AnyObject]){
        self.books = []
        self.name = dictionary ["name"] as? String ?? "No Category"
        if let libros = dictionary ["books"] as?  [[String:AnyObject]] {
        
        for l in libros {
            books.append(Book(dictionary: l))
            }
            
            
        }
    }
    
    
    
}
