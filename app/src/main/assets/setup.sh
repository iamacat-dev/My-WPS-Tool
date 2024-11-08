# !/bin/bash
am start -n com.termux/com.termux.app.TermuxActivity
sleep 1
input text "apt update && apt upgrade -y && pkg install -y root-repo && pkg install -y git tsu python wpa-supplicant pixiewps iw openssl && pkg install python -y && pkg install python2 -y && pkg install python3 -y && pkg install git -y && git clone https://github.com/kimocoder/OneShot.git"
input keyevent 66