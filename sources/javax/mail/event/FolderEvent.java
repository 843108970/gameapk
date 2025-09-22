package javax.mail.event;

import javax.mail.Folder;

public class FolderEvent extends MailEvent {
    public static final int CREATED = 1;
    public static final int DELETED = 2;
    public static final int RENAMED = 3;
    private static final long serialVersionUID = 5278131310563694307L;
    protected transient Folder folder;
    protected transient Folder newFolder;
    protected int type;

    public FolderEvent(Object obj, Folder folder2, int i) {
        this(obj, folder2, folder2, i);
    }

    public FolderEvent(Object obj, Folder folder2, Folder folder3, int i) {
        super(obj);
        this.folder = folder2;
        this.newFolder = folder3;
        this.type = i;
    }

    public void dispatch(Object obj) {
        if (this.type == 1) {
            ((FolderListener) obj).folderCreated(this);
        } else if (this.type == 2) {
            ((FolderListener) obj).folderDeleted(this);
        } else if (this.type == 3) {
            ((FolderListener) obj).folderRenamed(this);
        }
    }

    public Folder getFolder() {
        return this.folder;
    }

    public Folder getNewFolder() {
        return this.newFolder;
    }

    public int getType() {
        return this.type;
    }
}
