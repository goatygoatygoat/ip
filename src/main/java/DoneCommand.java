public class DoneCommand extends Command {
    private int taskno;

    DoneCommand(int taskno) {
        this.taskno = taskno;
    }

    @Override
    void execute(TaskList tasks, Ui ui, Storage storage) {
        tasks.set(this.taskno - 1, tasks.get(this.taskno - 1).done());
        ui.done(tasks.get(this.taskno - 1).toString());
        storage.savetasks(tasks);
    }

    @Override
    boolean isExit() {
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        } else if (obj instanceof DoneCommand) {
            DoneCommand dc = (DoneCommand) obj;
            return dc.taskno == this.taskno;
        }
        return false;
    }
}
