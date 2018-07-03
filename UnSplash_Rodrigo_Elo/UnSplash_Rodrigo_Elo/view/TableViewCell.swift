//
//  TableViewCell.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import UIKit
import Kingfisher


class TableViewCell: UITableViewCell {

    @IBOutlet weak var avatarImg: UIImageView!
    @IBOutlet weak var userLabel: UILabel!
    @IBOutlet weak var imageSplash: UIImageView!
    @IBOutlet weak var dateLabel: UILabel!
    
    
    
    func setup(photoResults: PhotoResult){
        
        if let theAvatar = photoResults.userData.usrImgs.small{
            let theImageAvatar = URL (string: theAvatar)
            avatarImg.kf.setImage(with: theImageAvatar)
        }
        
        if let theImage = photoResults.imgs.small{
            let TheImageSplash = URL(string: theImage)
            imageSplash.kf.setImage(with: TheImageSplash)
        }
        
        userLabel.text = photoResults.userData.username
        dateLabel.text = photoResults.created_at
        
        
        
    }
    
    override func awakeFromNib() {
        super.awakeFromNib()
        
    }

    override func setSelected(_ selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }

}
