//
//  photoService.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation
class PhotoService{
    
    func search(query: String, page: Int = 0, completionOfView: @escaping ([PhotoResult]) -> Void ){
        let dao = PhotoDao()
        dao.getResultsFromPhotoApi(query, page: page) { (photoResult) in
            completionOfView(photoResult)
        }
    }
    
    func stats(photoId: String, completionOfView: @escaping ((PhotoStats)-> Void)){
        let dao = PhotoDao()
        dao.getStatsFromApi(photoId) { (photoStats) in
            completionOfView(photoStats)
        }
    }
    
    func userData(username: String, completionOfView: @escaping ((User)->Void)){
        let dao = PhotoDao()
        dao.userData(username) { (userData) in
            completionOfView(userData)
        }
    
    }
    
    
}
