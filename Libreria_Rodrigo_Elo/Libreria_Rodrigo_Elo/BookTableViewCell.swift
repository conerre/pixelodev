//
//  BookTableViewCell.swift
//  Libreria_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 23/05/2018.
//  Copyright © 2018 pixelo.com.ar. All rights reserved.
//

import UIKit

class BookTableViewCell: UITableViewCell {

    
    @IBOutlet weak var tituloLabel: UILabel!
    
    @IBOutlet weak var autorLabel: UILabel!
    
    
    @IBOutlet weak var stockLabel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
