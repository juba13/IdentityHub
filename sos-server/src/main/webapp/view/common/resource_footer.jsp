<script src="<c:url value="/resources/vendor/jquery/jquery.min.js" />"></script>
<script src="<c:url value="/resources/vendor/bootstrap/js/bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/vendor/metisMenu/metisMenu.min.js" />"></script>
<script src="<c:url value="/resources/dist/js/sb-admin-2.js" />"></script>
<script src="<c:url value="/resources/vendor/datatables/js/jquery.dataTables.min.js" />"></script>
<script src="<c:url value="/resources/vendor/datatables-plugins/dataTables.bootstrap.min.js" />"></script>
<script src="<c:url value="/resources/vendor/datatables-responsive/dataTables.responsive.js" />"></script>

<script type="text/javascript" src="//gyrocode.github.io/jquery-datatables-checkboxes/1.2.11/js/dataTables.checkboxes.min.js"></script>
<script type="text/javascript">
    $(document).ready(function() { 
        $('#dataTables-example').DataTable({
            responsive: true
        });
    });
    
    
    
   $(document).ready(function() {
       
   var selected_user = [<c:forEach items="${app.users}" var="user">'${user.id}',</c:forEach>'NULL'];
   
   
   var table = $('#dataTables-multi').DataTable({  
       responsive: true,
       
      'columnDefs': [
         {
            'targets': 0,
            'checkboxes': {
               'selectRow': true
            }
         }
      ],
      'select': {
         'style': 'multi'
      },
      'order': [[1, 'asc']], 
      rowCallback: function ( row, data ) {
         $('input.dt-checkboxes', row).prop( 'checked', selected_user.includes(data[0]) );
      }
   });
   
   $('#frm-app-users').on('submit', function(e){
      var form = this;
      
      
      var rows_selected = table.column(0).checkboxes.selected();

      // Iterate over all selected checkboxes
      $.each(rows_selected, function(index, rowId){
         
         $(form).append(
             $('<input>')
                .attr('type', 'hidden')
                .attr('name', 'user_id[]')
                .val(rowId)
         );
      });
      
      

   });   
});
    
</script>

</body>
</html>
