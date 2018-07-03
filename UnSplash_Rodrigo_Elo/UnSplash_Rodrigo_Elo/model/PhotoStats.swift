//
//  PhotoStatics.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 01/07/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation

class PhotoStats{
    
    var idStats: String
    var downloads: StatsDownload
    var views: StatsView
    var likes: StatsLike
    
    
    init(dictionary: [String:AnyObject]){
        self.idStats = dictionary["id"] as? String ?? "noPhotoId"
        self.downloads = StatsDownload(dictionary: dictionary["downloads"] as? [String:AnyObject] ?? [:])
        self.views = StatsView(dictionary: dictionary["views"] as? [String:AnyObject] ?? [:])
        self.likes = StatsLike(dictionary: dictionary["likes"] as? [String:AnyObject] ?? [:])
        
        
    }
}
