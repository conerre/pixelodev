//
//  StatsLike.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 02/07/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation
class StatsLike{
    
    var totalLike : Int
    
    
    init(dictionary: [String:AnyObject]){
        self.totalLike = dictionary["total"] as? Int ?? -1
    }
    
}
