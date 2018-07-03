//
//  Photo.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation


class PhotoResult {
    
    var id : String?
    var created_at : String?
    var updated_at: String?
    var color : String?
    var description : String?
    var imgs : PhotoUrls
    var userData : User
 
    
    
    init(whit dictionary: [String:AnyObject]) {
        self.id = dictionary["id"] as? String ?? "No ID"
        self.created_at = dictionary["created_at"] as? String
        self.updated_at = dictionary["updated_at"] as? String
        self.color = dictionary["color"] as? String ?? "#000000"
        self.description = dictionary["description"] as? String ?? "No Description Avaiable"
        self.imgs = PhotoUrls(dictionary: dictionary["urls"] as? [String:AnyObject] ?? [:])
        self.userData = User(dictionary: dictionary["user"] as? [String:AnyObject] ?? [:])
        
    }
    
}
