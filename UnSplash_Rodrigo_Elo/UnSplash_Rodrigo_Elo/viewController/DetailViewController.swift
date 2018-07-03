//
//  DetailViewController.swift
//  UnSplash_Rodrigo_Elo
//
//  Created by Rodrigo Elo on 27/06/18.
//  Copyright © 2018 Rodrigo Elo. All rights reserved.
//

import UIKit

class DetailViewController: UIViewController {

    var photoResult : PhotoResult?
    var user : User?
    var photoStats : PhotoStats?
    var photoId : String = ""
    
    
    @IBOutlet weak var avatarIV: UIImageView!
    @IBOutlet weak var splashIV: UIImageView!
    @IBOutlet weak var userLabel: UILabel!
    @IBOutlet weak var btnUserName: UIButton!
    @IBOutlet weak var likeLabel: UILabel!
    @IBOutlet weak var viewLabel: UILabel!
    @IBOutlet weak var downLabel: UILabel!
    @IBOutlet weak var descriptionLabel: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let serviceStats = PhotoService()
        serviceStats.stats(photoId: photoId, completionOfView: { (photoStats) in
            self.photoStats = (photoStats)
            self.likeLabel.text = "\(photoStats.likes.totalLike)"
            self.viewLabel.text = "\(photoStats.views.totalView)"
            self.downLabel.text = "\(photoStats.downloads.totalDownload)"
            self.descriptionLabel.text = self.photoResult?.description
        })
        
        
        if let theAvatar = photoResult?.userData.usrImgs.small{
            let theImageAvatar = URL (string: theAvatar)
            avatarIV.kf.setImage(with: theImageAvatar)
        }
        if let theImage = photoResult?.imgs.regular{
            let theSplashImage = URL (string: theImage)
            splashIV.kf.setImage(with: theSplashImage)
        }
        
        if let theUser = photoResult{
        btnUserName.setTitle(theUser.userData.name, for: UIControlState())
        userLabel.text = user?.location
        
        }
        

    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        if let destination = segue.destination as? UserDetailViewController {
            destination.userNameApi = (user?.username)!
            
        }
    }


}
