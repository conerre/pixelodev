//
//  Book.swift
//  Libreria_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 21/05/2018.
//  Copyright © 2018 pixelo.com.ar. All rights reserved.
//

import Foundation
class Book{
    var title : String
    var author: String
    var isbn: String
    var stock: Int
    var price: Double
    var language : String
    


init (title: String, author: String, isbn: String, stock: Int, price: Double, language: String){
    
    self.title = title
    self.author = author
    self.isbn = isbn
    self.stock = stock
    self.price = price
    self.language = language
}

    init (dictionary: [String: AnyObject]){
        self.title = dictionary["title"] as? String ?? "no Title"
        self.author = dictionary["author"] as? String ?? "no Author"
        self.isbn = dictionary["isbn"] as? String ?? "No Isbn"
        self.stock = dictionary["stock"] as? Int ?? -1
        self.price = dictionary["price"] as? Double ?? -1
        self.language = dictionary["language"] as? String ?? "No Lang"
    }

}
