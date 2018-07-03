//
//  ViewController.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import UIKit


class ViewController: UIViewController {

    @IBOutlet weak var fieldSearch: UITextField!
    @IBOutlet weak var searchBtn: UIButton!
  
    
    @IBAction func searchBtn(_ sender: Any) {
        if fieldSearch.text != ""{
            if let destination = storyboard?.instantiateViewController(withIdentifier: "firstView") as? ContentTableViewController{
                destination.query = fieldSearch.text
                navigationController?.pushViewController(destination, animated: true)
            }
        }
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
       
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }

}

