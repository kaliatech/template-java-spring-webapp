# Generic example
mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./my3rdpartyfile.jar -DgroupId=com.3rdpartycompany -DartifactId=my3rdpartylib -Dversion=x.x -Dpackaging=jar -DlocalRepositoryPath=.

# Native library example (serialio)
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./Serialio.jar -DgroupId=com.serialio -DartifactId=serialio -Dversion=8.3 -Dpackaging=jar -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jspComm.jar -DgroupId=com.serialio -DartifactId=serialio-javaxcommapi -Dversion=8.3 -Dpackaging=jar -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jspWin.dll (manually copied/renamed x32 version) -DgroupId=com.serialio -DartifactId=serialio-native-win-x32 -Dversion=8.3 -Dpackaging=dll -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jspWin.dll (manually copied/renamed x64 version) -DgroupId=com.serialio -DartifactId=serialio-native-win-x64 -Dversion=8.3 -Dpackaging=dll -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./libjspLux86.so.4.7 -DgroupId=com.serialio -DartifactId=serialio-native-linux-x32 -Dversion=8.3 -Dpackaging=so -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./libjspLux86_64bit.so -DgroupId=com.serialio -DartifactId=serialio-native-linux-x64 -Dversion=8.3 -Dpackaging=so -DlocalRepositoryPath=.
#Note that after installing above, have to go in to repo and manually copy the version named files to unversioned "jspWin.dll" since serialio is hardcoded to look for that dll name regardless of arch.

# Native library example (jinput)
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jinput.jar -DgroupId=net.java.games -DartifactId=jinput -Dversion=20130718 -Dpackaging=jar -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jinput-dx8.dll -DgroupId=net.java.games -DartifactId=jinput-native-win-x32 -Dversion=20130718 -Dpackaging=dll -DlocalRepositoryPath=.
#mvn org.apache.maven.plugins:maven-install-plugin:2.3.1:install-file -Dfile=./jinput-dx8_64.dll -DgroupId=net.java.games -DartifactId=jinput-native-win-x64 -Dversion=20130718 -Dpackaging=dll -DlocalRepositoryPath=.



