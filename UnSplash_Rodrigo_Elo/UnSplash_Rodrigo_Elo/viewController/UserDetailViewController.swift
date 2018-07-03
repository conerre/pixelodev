//
//  UserDetailViewController.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 02/07/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import UIKit
import Kingfisher

class UserDetailViewController: UIViewController {

    
    @IBOutlet weak var userName: UILabel!
    @IBOutlet weak var fullName: UILabel!
    @IBOutlet weak var bigAvatar: UIImageView!
    @IBOutlet weak var labelFolowers: UILabel!
    @IBOutlet weak var labelFolowin: UILabel!
    @IBOutlet weak var labelDownloads: UILabel!
    @IBOutlet weak var labelImgs: UILabel!
    @IBOutlet weak var labelLikes: UILabel!
    
    var userData : User?
    var userNameApi: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
    let serviceUserData = PhotoService()
        serviceUserData.userData(username: userNameApi, completionOfView: { (userData) in
            self.userData = (userData)
            self.userName.text = userData.username
            self.fullName.text = userData.name
            self.labelFolowers.text = "\(String(describing: userData.followers))"
            self.labelFolowin.text = "\(String(describing: userData.following))"
            self.labelDownloads.text = "\(String(describing: userData.downloads))"
            self.labelImgs.text = "\(String(describing: userData.total_photos))"
            self.labelLikes.text = "\(String(describing: userData.likes))"
        
            if let bigAvatar = userData.usrImgs.large{
                let avatarUrl = URL(string: bigAvatar)
                self.bigAvatar.kf.setImage(with: avatarUrl)
            }
        })
       
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    

}
