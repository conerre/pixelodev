//
//  UserUrls.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation


class UserUrls{
    
    var small : String?
    var medium : String?
    var large : String?
    
    
    init(dictionary : [String:AnyObject]) {
        self.small = dictionary["small"] as? String
        self.medium = dictionary["medium"] as? String
        self.large = dictionary["large"] as? String
    }
    
}
