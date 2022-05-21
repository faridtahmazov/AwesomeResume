var count = 0;
function addRow(){
    let table = document.getElementById("skillsTable");


    let row = table.insertRow(table.rows.length);

    let skillName = row.insertCell(0);
    let rangePower = row.insertCell(1);
    let numPower = row.insertCell(2);
    skillName.innerHTML = `<input type="text" class="form-control" name="skill">`;
    rangePower.innerHTML = `<input type="range" class="form-range" id="controlRange${count}" min="0" max="10"
                            step="1" onInput="$('#rangeval${count}').html($(this).val())"/>`;
    numPower.innerHTML = `<span id="rangeval${count++}" style="font: bold 18px 'arial'" name="power"></span>`


    // let template = `
    //                 <tr id="newSkill">
    //                     <td>
    //
    //                     </td>
    //                     <td>
    //                         <div class="container">
    //                             <div class="form-group">
    //
    //                             </div>
    //                         </div>
    //                     </td>
    //                     <td>
    //
    //                     </td>
    //                 </tr>`;
    // table.innerHTML += template;

}