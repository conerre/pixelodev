//
//  StatsView.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 02/07/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation
class StatsView{
    
    var totalView : Int
    
    init(dictionary: [String:AnyObject]){
        self.totalView = dictionary["total"] as? Int ?? -1
    }
}
