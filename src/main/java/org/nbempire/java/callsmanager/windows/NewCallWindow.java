package org.nbempire.java.callsmanager.windows;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;
import org.nbempire.java.bocswt.widgets.DirectoryBrowserWidget;
import org.nbempire.java.bocswt.windows.BaseWindow;
import org.nbempire.java.bocui.BasicUIKeys;
import org.nbempire.java.callsmanager.MainKeys;
import org.nbempire.java.callsmanager.domain.Call;
import org.nbempire.java.callsmanager.domain.Contact;
import org.nbempire.java.callsmanager.domain.Task;
import org.nbempire.java.callsmanager.service.impl.CallServiceImpl;
import org.nbempire.java.callsmanager.util.CallManagerUtil;

/**
 * @author Barrios, Nahuel.
 * @version 1.0
 * @since Mar 19, 2010, 10:35:55 AM
 */
public class NewCallWindow extends BaseWindow {

    private Call newCall;

    private static final int COL_TASK_NUMBER_WIDTH = 40;

    private static final int COL_SHORT_DESCRIPT_WIDTH = 320;

    private static final int SHORT_DESCRIPT_WIDTH = 500;

    private static final int LONG_DESCRIPT_WIDTH = 700;

    private static final int NORMAL_TEXT_HEIGHT = 20;

    private Composite cpst_leftColumn;

    private Text newPath;

    private Text callWith;

    private Text subject;

    private Table tbl_tasks;

    private Composite cpst_rightColumn;

    private Text shortDescript;

    private Text longDescript;

    private Button btn_addTask;

    public NewCallWindow(Display display) {
        super(display, SWT.APPLICATION_MODAL | SWT.SHELL_TRIM);
        newCall = new Call();
    }

    @Override
    protected void buildWindow(Shell shell) {
        this.setGenericFeatures(shell);

        cpst_leftColumn = new Composite(shell, SWT.NONE);
        cpst_leftColumn.setLayout(new RowLayout(SWT.VERTICAL));

        cpst_rightColumn = new Composite(shell, SWT.NONE);
        cpst_rightColumn.setLayout(new RowLayout(SWT.VERTICAL));

        this.buildLeftColumn();

        cpst_rightColumn.setSize(880, MainKeys.APP_HEIGHT);
        this.buildRightColumn();
    }

    /**
     * Builds the left panel of the window.
     */
    private void buildLeftColumn() {

        // Call with section
        Composite cpst_form = new Composite(cpst_leftColumn, 0);
        cpst_form.setLayout(new GridLayout(4, false));

        GridData gd_rightColumn = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
        gd_rightColumn.widthHint = 300;

        new Label(cpst_form, SWT.NONE).setText(MainKeys.LABEL_OUTPUT_DIRECTORY_PATH);
        newPath = new Text(cpst_form, SWT.BORDER);
        newPath.setLayoutData(gd_rightColumn);
        new DirectoryBrowserWidget(cpst_form, newPath, BasicUIKeys.LABEL_BROWSE);

        new Label(cpst_form, SWT.NONE).setText(MainKeys.LABEL_CALL_WITH);
        callWith = new Text(cpst_form, SWT.BORDER);
        callWith.setLayoutData(gd_rightColumn);
//        callWith.addModifyListener(new ModifyListener() {
//            // TODO : Functionality: implementar el buscador de contactos dinamico.
//            public void modifyText(ModifyEvent e) {
//                List<Contact> ct =
//                        ContactServiceImpl.getInstance().getBy(callWith.getText());
//                if (ct.size() == 1) {
//                    newCall.setContact(ct.get(0));
//                    callWith.setText(newCall.getContact().getFullName());
//                }
//            }
//        });
        new Label(cpst_form, SWT.NONE);

        new Label(cpst_form, SWT.NONE).setText(MainKeys.LABEL_SUBJECT);
        subject = new Text(cpst_form, SWT.BORDER);

        cpst_form.setTabList(new Control[]{newPath, callWith, subject});

        // Tasks table section
        this.buildTasksTable(cpst_leftColumn);

        this.buildBottomToolbar();

        // cpst_leftColumn.pack();
    }

    private void buildBottomToolbar() {
        super.buildBottomToolbar(cpst_leftColumn, false, true, false, false, false);

        buildExportButton(bottomToolbar);

        //btnSave.setText(MainKeys.LABEL_EXPORT_AND_EXIT);
        //btnSave.addSelectionListener(new SelectionListener() {
        //    public void widgetSelected(SelectionEvent e) {
        //        saveNewCall();
        //        exitApplication(e);
        //    }
        //
        //    public void widgetDefaultSelected(SelectionEvent e) {
        //    }
        //});
    }

    private void buildExportButton(Composite parent) {
        Button btn_export = new Button(parent, SWT.NONE);
        btn_export.setText(MainKeys.LABEL_EXPORT);
        btn_export.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {
                saveNewCall();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });
    }

    /**
     * Performs the required actions to save the new call.
     */
    private void saveNewCall() {
        String filePath = newPath.getText();
        if (!filePath.equals("")) {
            newCall.setOutputDirectory(filePath);
        }

        String subject = this.subject.getText();
        if (!subject.equals("")) {
            newCall.setSubject(subject);
        }

        newCall.setContact(new Contact(callWith.getText()));

        CallServiceImpl.getInstance().exportToFile(newCall);
    }

    /**
     * Builds the right panel of the window.
     */
    private void buildRightColumn() {
        Composite cpst_form = new Composite(cpst_rightColumn, 0);
        cpst_form.setLayout(new GridLayout(3, false));

        new Label(cpst_form, SWT.NONE).setText(MainKeys.LABEL_SHORT_DESCRIPT);
        shortDescript = new Text(cpst_form, SWT.BORDER);
        GridData gd_shortDescript = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
        gd_shortDescript.widthHint = 500;
        shortDescript.setLayoutData(gd_shortDescript);

        longDescript = new Text(cpst_form, SWT.MULTI | SWT.BORDER);
        GridData gd_longDescript = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
        gd_longDescript.widthHint = 700;
        longDescript.setLayoutData(gd_longDescript);
        longDescript.addModifyListener(new ModifyListener() {
            public void modifyText(ModifyEvent e) {
                if (!CallManagerUtil.isBuild(btn_addTask)) {
                    buildAddTaskButton(cpst_rightColumn);
                }
            }
        });

        cpst_form.setTabList(new Control[]{shortDescript, longDescript});
        // cpst_rightColumn.pack();
        this.refreshCustomSizes();
    }

    private void refreshCustomSizes() {
        shortDescript.setSize(SHORT_DESCRIPT_WIDTH, NORMAL_TEXT_HEIGHT);
        longDescript.setSize(LONG_DESCRIPT_WIDTH, NORMAL_TEXT_HEIGHT);
    }

    /**
     * Builds add task button.
     */
    private void buildAddTaskButton(Composite parent) {
        btn_addTask = new Button(parent, SWT.NONE);
        btn_addTask.setText(MainKeys.LABEL_ADD_TASK);
        btn_addTask.addSelectionListener(new SelectionListener() {
            public void widgetSelected(SelectionEvent e) {

                // Adds the task to the Call object.
                Task newTask = new Task(getNewTaskNumber());
                newTask.setShortDescript(shortDescript.getText());
                newTask.setLongDescript(longDescript.getText());

                newCall.getTasks().add(newTask);

                // Removes the data from the controls.
                shortDescript.setText("");
                longDescript.setText("");

                // Adds the new item to the table
                TableItem newRow = new TableItem(tbl_tasks, SWT.NONE);
                newRow.setText(0, newTask.getTaskNumber().toString());
                newRow.setText(1, newTask.getShortDescript());

                cpst_leftColumn.pack();
            }

            public void widgetDefaultSelected(SelectionEvent e) {
            }
        });

        parent.pack();
        this.refreshCustomSizes();
    }

    /**
     * Gets the new task number based on the added tasks of the table.
     *
     * @return
     */
    private Integer getNewTaskNumber() {
        return tbl_tasks.getItems().length;
    }

    private void buildTasksTable(Composite parent) {
        tbl_tasks = new Table(parent, SWT.NONE);
        tbl_tasks.setHeaderVisible(true);
        tbl_tasks.setLinesVisible(true);

        TableColumn col_taskNumber = new TableColumn(tbl_tasks, SWT.NONE);
        col_taskNumber.setWidth(COL_TASK_NUMBER_WIDTH);
        col_taskNumber.setText(MainKeys.LABEL_TASK_NUMBER);

        TableColumn col_shortDescript = new TableColumn(tbl_tasks, SWT.NONE);
        col_shortDescript.setWidth(COL_SHORT_DESCRIPT_WIDTH);
        col_shortDescript.setText(MainKeys.LABEL_SHORT_DESCRIPT);
    }

    @Override
    protected void setGenericFeatures(Shell shell) {
        shell.setText(MainKeys.NEW_CALL_VIEW_TITLE);

        RowLayout layout = new RowLayout(SWT.HORIZONTAL);
        // layout.marginHeight = MainKeys.APP_MARGIN_HEIGHT;
        layout.marginBottom = MainKeys.APP_MARGIN_BOTTOM;
        layout.marginWidth = MainKeys.APP_MARGIN_WIDTH;
        layout.spacing = MainKeys.APP_LAYOUT_SPACING;

        shell.setLayout(layout);
    }

    @Override
    protected void setSizes(Shell shell) {
        shell.setSize(MainKeys.APP_WIDTH, MainKeys.APP_HEIGHT);
    }
}
