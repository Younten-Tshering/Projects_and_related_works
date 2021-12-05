# Backup configuration .sh file

today=`date +%Y%m%d` # file and folder name
backupRoot=/home/wae/projects/web8-app/webproject/app/assets/backup_dump # save location
todayPath=$backupRoot/$today # file path
scriptFile=/home/wae/projects/web8-app/webproject/dailyBackup.sh


executeProcess=`ps ax | grep "sh $scriptFile" | grep -v grep | wc -l`
if [ $executeProcess -le 2 ] ; then

if [ ! -d $todayPath ] ; then    # Check for if the "daily" directory exits
mkdir -p $todayPath    # if not exist then make directory
chmod 777 $todayPath   # Permission for path

fi

# Postgres Backup

pg_dump -U wae webproject_development | gzip > $backupRoot/$today/$today.psql

echo "Creating postgres backup success!"  

fi
