//
//  ViewController.swift
//  Libreria_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 21/05/2018.
//  Copyright © 2018 pixelo.com.ar. All rights reserved.
//

import UIKit



class WelcomeViewController: UIViewController {

    @IBOutlet weak var fieldUser: UITextField!
    @IBOutlet weak var enterBtn: UIButton!
    @IBAction func ingresar(_ sender: Any) {
        
    }
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        
    }

    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if segue.identifier == "tobookdetail"{
        let destiny = segue.destination as? BooksTableViewController
        destiny?.titleBar = fieldUser.text!
        }
        
    
    }

}

