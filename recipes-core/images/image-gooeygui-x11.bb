SUMMARY = "Template yocto image for gooeygui" 
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
inherit core-image
# set image type 

IMAGE_FEATURES += " debug-tweaks"
EXTRA_IMAGE_FEATURES = "tools-sdk tools-debug"

# x11 support 
# Installs the X server. see also x11 base 
# meta/recipes-graphics/packagegroups
IMAGE_FEATURES += " x11 x11-base" 
IMAGE_INSTALL += " gdbserver "

IMAGE_INSTALL:append = "\
gooeygui-libc \
gooeygui-example \
mesa \
"

IMAGE_INSTALL:append = "\
openbox \ 
xterm \
bash \
"
