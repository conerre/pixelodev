//
//  PhotoUrls.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation

class PhotoUrls {
    
    var raw : String?
    var full : String?
    var regular : String?
    var small : String?
    var thumb : String?
    
    init (dictionary: [String:AnyObject] ){
        self.raw = dictionary["raw"] as? String
        self.full = dictionary["full"] as? String
        self.regular = dictionary["regular"] as? String
        self.small = dictionary["small"] as? String
        self.thumb = dictionary["thumb"] as? String
    }
}
