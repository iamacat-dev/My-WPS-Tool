# !/bin/bash
am start -n com.termux/com.termux.app.TermuxActivity
sleep 1
input text "sudo python3 OneShot/oneshot.py -i wlan0 --iface-down -B"
input keyevent 66
