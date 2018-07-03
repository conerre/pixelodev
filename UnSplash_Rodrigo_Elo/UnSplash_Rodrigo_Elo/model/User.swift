//
//  User.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation


class User{
    
    var id : String
    var username : String
    var name: String
    var bio: String
    var location : String
    var usrImgs: UserUrls
    var followers: Int
    var following: Int
    var downloads: Int
    var total_photos: Int
    var likes: Int
    
    
    
    init(dictionary: [String:AnyObject]) {
        self.id = dictionary["id"] as? String ?? "no Id"
        self.username = dictionary["username"] as? String ?? "No userName"
        self.name = dictionary["name"] as? String ?? "no Name"
        self.bio = dictionary["bio"] as? String ?? "No Bio Avaiable"
        self.location = dictionary["location"] as? String ?? ""
        self.usrImgs = UserUrls(dictionary: dictionary["profile_image"] as? [String:AnyObject] ?? [:])
        self.followers = dictionary["followers_count"] as? Int ?? -1
        self.following = dictionary["following_count"] as? Int ?? -1
        self.downloads = dictionary["downloads"] as? Int ?? -1
        self.total_photos = dictionary["total_photos"] as? Int ?? -1
        self.likes = dictionary["total_likes"] as? Int ?? -1
        
        
    }
    
}
