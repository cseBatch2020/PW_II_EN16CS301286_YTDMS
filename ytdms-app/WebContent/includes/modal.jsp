 <%
      int id=(int)session.getAttribute("groupId");
%>
<div class="modal fade text-dark" id="contactModal"  role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
              <span aria-hidden="true">&times;</span>
            </button>
        </div>
        <div class="modal-body">
            <form action="AddPermissionController">
            <input type="hidden" name="moduleId" value="${groupId}"/>
            <div class="form-group">
              <label for="name">Add Permission</label>
              <input type="text" class="form-control" name="name" required />
            </div>

           
              
          

        <div class="modal-footer">
           <input type="submit" class="btn btn-info btn-block" value="CREATE" role="button"/>
      </div>
      </form>
      </div>
    </div>
 </div> 
 </div>