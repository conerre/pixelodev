//
//  SearchTableViewController.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//
import Foundation
import UIKit


class ContentTableViewController: UITableViewController {
    
    var query : String?
    var photoResult : [PhotoResult] = []
    var photoStats : [PhotoStats] = []
    let service = PhotoService()
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
         self.title = query
        
        service.search(query: query!, page: 0) { (photoResult) in
            self.photoResult = photoResult
            self.tableView.reloadData()
        }
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }

    // MARK: - Table view data source

    override func numberOfSections(in tableView: UITableView) -> Int {
    
        return 1
    }

    override func tableView(_ tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
      
        return photoResult.count
    }

  
    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "photoCell", for: indexPath)
       
            if let aCell = cell as? TableViewCell{
            aCell.setup(photoResults: photoResult[indexPath.row])
         
            ///Aca Traigo el color de fondo para la celda
            let colorForBG = UIColor(hexString: photoResult[indexPath.row].color!)
            aCell.backgroundColor = colorForBG
        }
        
            ///Cuando se estan por acabar las fotos, pido mas
            if indexPath.row == photoResult.count - 5 {
                loadNextPage()
            }
        return cell
        }
        
        ///Funcion para pedir mas fotos, le pasa el numero de elementos del array
        private func loadNextPage(){
            let service = PhotoService()
            service.search(query: query!, page: photoResult.count) { (photoResults) in
                self.photoResult.append(contentsOf: photoResults)
                self.tableView.reloadData()
            }
        }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destination = segue.destination as? DetailViewController{
            if let positionPh = tableView.indexPathForSelectedRow{
                let selectedPh = photoResult[positionPh.row]
               destination.photoResult = selectedPh
               destination.user = selectedPh.userData
               destination.photoId = selectedPh.id!
                
            }
        }
    }

   
}
