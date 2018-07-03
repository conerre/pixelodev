//
//  PhotoDao.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import Foundation
import Alamofire

class PhotoDao{
    
    var client_id = "ea06721727df59890e70700d68322bcafdaa3c3b9784b18fcdceef97784def65"
    
    
    //// Query de las fotos
    func getResultsFromPhotoApi(_ query: String, page: Int,
                                completion: @escaping (([PhotoResult]) -> Void)){
        let url = "https://api.unsplash.com/search/photos?query=\(query)&client_id=\(client_id)&page=\(page)"
        
        Alamofire.request(url).responseJSON { (response) in
        
        if let mainDictionary = response.result.value as? [String:AnyObject]{
            if let result = mainDictionary["results"] as? [[String:AnyObject]]{
                
                var photosResult : [PhotoResult] = []
                for aDictionary in result{
                let newPhotoResult = PhotoResult(whit: aDictionary)
                photosResult.append(newPhotoResult)
            }
            completion(photosResult)
            }
            else{
                completion([])
            }
            
        }
        }
    }
    
    
    ////Estadisticas
    func getStatsFromApi (_ photoId: String, completion: @escaping ((PhotoStats) -> Void)){
        let url = "https://api.unsplash.com/photos/\(photoId)/statistics?client_id=\(client_id)"
        
        Alamofire.request(url).responseJSON { (response) in
            if let statsJson = response.result.value as? [String:AnyObject]{
                let theStats = PhotoStats(dictionary: statsJson)
                completion(theStats)
            }
        }
        }
   
    
    /////Datos del Usuario
    func userData (_ userName: String, completion: @escaping ((User) -> Void)){
        let url = "https://api.unsplash.com/users/\(userName)?client_id=\(client_id)"
        
        Alamofire.request(url).responseJSON { (response)
            in if let userJson = response.result.value as? [String:AnyObject]{
                let theUserData = User(dictionary: userJson)
                completion(theUserData)
            }
        }
    }
    
    }
    
    

