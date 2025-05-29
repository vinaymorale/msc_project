variable "flavor" { default = "m1.large" }
variable "image" { default = "Debian 12 20241202" }
variable "name1" { default = "DebProject" }

variable "keypair" { default = "project" } # you may need to change this
variable "network" { default = "terraform_network" }   # you need to change this

variable "pool" { default = "cscloud_private_floating" }
variable "server1_script" { default = "./project.sh" }
variable "security_description" { default = "Terraform security group" }
variable "security_name" { default = "tf_securityMat" }
