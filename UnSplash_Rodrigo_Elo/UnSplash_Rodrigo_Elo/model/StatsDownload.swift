//
//  StatsDownload.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 02/07/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation
class StatsDownload {
    
    var totalDownload : Int
    
    init(dictionary: [String:AnyObject]){
        self.totalDownload = dictionary["total"] as? Int ?? -1
        
    }
    
}
