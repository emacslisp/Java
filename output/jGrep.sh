SCRIPT_PATH=$(dirname `which $0`)
java -cp $(SCRIPT_PATH)/dw-lib.jar com.dw.lib.Grep $@
