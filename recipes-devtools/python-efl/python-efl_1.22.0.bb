SUMMARY = "Enlightenment Foundation Libraries, Python Bindings"
LICENSE = "GPLv3 & LGPLv3"
HOMEPAGE = "https://www.enlightenment.org"

DEPENDS = " \
    efl \
    efl-native \
    dbus-native \
    python-dbus \
    python-dbus-native \
    python-dbus-dev \
    python-dbus-dev-native \
    python-native \
    python-cython-native \
    "    

SRC_URI = " \
    git://git.enlightenment.org/bindings/python/python-efl.git;protocol=https;branch=python-efl-1.22 \
	"

SRCREV = "v${PV}"

LIC_FILES_CHKSUM = " \
    file://COPYING;md5=d32239bcb673463ab874e80d47fae504 \
    file://COPYING.LESSER;md5=e6a600fd5e1d9cbde2d983680233ad02 \
    "

inherit python-dir setuptools

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
